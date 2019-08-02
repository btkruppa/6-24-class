import React, { Component } from 'react'
import Card from '../../models/card';
import { Game } from '../../models/game';
import { ButtonDropdown, DropdownToggle, DropdownMenu, DropdownItem, Button } from 'reactstrap';
import User from '../../models/user';
import { IState } from '../../reducers';
import { connect } from 'react-redux';
import { cardClient } from '../../axios/card.client';

interface IProps {
    currentUser?: User
}

interface IComponentState {
    cards: Card[],
    games: Game[],
    gameDropdown: {
        isOpen: boolean,
        selection: string
    }
}

export class Cards extends Component<IProps, IComponentState> {
    constructor(props: any) {
        super(props);
        this.state = {
            cards: [],
            games: [],
            gameDropdown: {
                isOpen: false,
                selection: 'All'
            }
        };
    }

    async componentDidMount() {
        this.getCards();
        this.getGames();
    }

    getCards = async () => {
        const resp = await cardClient.get<Card[]>('/cards');
        const cardsFromServer = resp.data;
        this.setState({
            cards: cardsFromServer,
            gameDropdown: {
                ...this.state.gameDropdown,
                selection: 'All'
            }
        });
        console.log(cardsFromServer);
    }

    getCardsByGameId = async (game: Game) => {
        const resp = await cardClient.get<Card[]>(`/cards/game/${game.id}`);
        const cardsFromServer = resp.data;
        this.setState({
            cards: cardsFromServer,
            gameDropdown: {
                ...this.state.gameDropdown,
                selection: game.name
            }
        });
        console.log(cardsFromServer);
    }

    getGames = async () => {
        const resp = await cardClient.get<Game[]>('/games');
        const games = resp.data;
        this.setState({
            games
        });
    }

    toggleGameDropdown = () => {
        this.setState({
            gameDropdown: {
                ...this.state.gameDropdown,
                isOpen: !this.state.gameDropdown.isOpen
            }
        });
    }

    sellCard = async(cardId: number) => {
        const body = {
            id: cardId,
            owner: null
        };
        const result = await cardClient.patch('/cards', body);
        const updatedCard = result.data;
        this.setState({
            ...this.state,
            cards: this.state.cards.map(card => {
                if(card.id === updatedCard.id) {
                    return updatedCard;
                } else {
                    return card;
                }
            })
        })
    }

    buyCard = async(cardId: number) => {
        const body = {
            id: cardId,
            owner: {
                id: this.props.currentUser && this.props.currentUser.id
            }
        };
        const result = await cardClient.patch('/cards', body);
        const updatedCard = result.data;
        this.setState({
            ...this.state,
            cards: this.state.cards.map(card => {
                if(card.id === updatedCard.id) {
                    return updatedCard;
                } else {
                    return card;
                }
            })
        })
    }

    getPurchaseOption = (card: Card) => {
        if(this.props.currentUser) {
            if (!card.owner) {
                return <td>
                    <Button color="success" onClick={() => this.buyCard(card.id)}>Buy</Button>
                </td>
            }
            else if (card.owner.id === this.props.currentUser.id) {
                return <td>
                    <Button color="danger" onClick={() => this.sellCard(card.id)}>Sell</Button>
                </td>
            }
        }
    }

    render() {
        const cards = this.state.cards;
        return (
            <div id="card-table-container">
                <ButtonDropdown id="card-game-dropdown"
                    isOpen={this.state.gameDropdown.isOpen}
                    toggle={this.toggleGameDropdown}>

                    <DropdownToggle caret>
                        {this.state.gameDropdown.selection}
                    </DropdownToggle>
                    <DropdownMenu right>
                        <DropdownItem onClick={this.getCards}>All</DropdownItem>
                        <DropdownItem divider />
                        {
                            this.state.games.map(game => (
                                <DropdownItem key={'game-dropdown-' + game.id}
                                    onClick={() => this.getCardsByGameId(game)}>
                                    {game.name}
                                </DropdownItem>
                            ))
                        }
                    </DropdownMenu>
                </ButtonDropdown>
                <table className="table table-striped table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Game</th>
                            <th scope="col">Condition</th>
                            <th scope="col">Value</th>
                            <th scope="col">Owner</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            cards.map(card =>
                                <tr key={'cardId-' + card.id}>
                                    <td>{card.name}</td>
                                    <td>{card.game.name}</td>
                                    <td>{card.quality.label}</td>
                                    <td>{card.value}</td>
                                    <td>{card.owner && card.owner.username}</td>
                                    {this.getPurchaseOption(card)}
                                </tr>)
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

const mapStateToProps = (state: IState) => ({
    currentUser: state.auth.currentUser
})

export default connect(mapStateToProps)(Cards);