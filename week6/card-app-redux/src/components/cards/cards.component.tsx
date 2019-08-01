import React, { Component } from 'react'
import Card from '../../models/card';
import { Game } from '../../models/game';
import { ButtonDropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import { environment } from '../../environment';

interface IState {
    cards: Card[],
    games: Game[],
    gameDropdown: {
        isOpen: boolean,
        selection: string
    }
}

export default class Cards extends Component<{}, IState> {
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
        const resp = await fetch(environment.context +'/cards', {
            credentials: 'include'
        });
        const cardsFromServer = await resp.json();
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
        const resp = await fetch(environment.context +'/cards/game/' + game.id, {
            credentials: 'include'
        });
        const cardsFromServer = await resp.json();
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
        const resp = await fetch(environment.context + '/games', {
            credentials: 'include'
        });
        const games = await resp.json();
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
                                </tr>)
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}
