import React, { Component } from 'react'
import Card from '../../models/card';

interface IState {
    cards: Card[]
}

export default class Cards extends Component<{}, IState> {
    constructor(props: any) {
        super(props);
        this.state = {
            cards: []
        };
    }

    async componentDidMount() {
        const resp = await fetch('http://localhost:8012/cards', {
            credentials: 'include'
        });
        const cardsFromServer = await resp.json();
        this.setState({
            cards: cardsFromServer
        });
        console.log(cardsFromServer);
    }

    render() {
        const cards = this.state.cards;
        return (
            <div id="card-table-container">
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
                                <tr key={'cardId-'+card.id}>
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
