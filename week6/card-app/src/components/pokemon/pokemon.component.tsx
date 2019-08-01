import React from 'react';
import { Button } from 'reactstrap';

interface IState {
    pokemon: any,
    pokemonId: number
}

export class Pokemon extends React.Component<{}, IState> {

    constructor(props: any) {
        super(props);
        this.state = {
            pokemon: null,
            pokemonId: 7
        }
    }

    updatePokemonId = (event: React.ChangeEvent<HTMLInputElement>) => {
        this.setState({
            pokemonId: +event.target.value
        })
    }

    findNewPokemon = async () => {
        const resp = await fetch('https://pokeapi.co/api/v2/pokemon/' + this.state.pokemonId);
        const pokemon = await resp.json();
        this.setState({
            pokemon
        });
    }

    getSprites = () => {
        if(!this.state.pokemon) {
            return [];
        }
        const spritesTSX: any[] = []
        const sprites = this.state.pokemon.sprites
        for(let sprite in sprites) {
            if(sprites[sprite]) {
                spritesTSX.push(<img key={'sprite-url' + sprites[sprite]} src={sprites[sprite]} alt="sprite" />)
            }
        }
        return spritesTSX;
    }

    render() {
        return (
            <div>
                <input name="pokemonId"
                    type="number"
                    value={this.state.pokemonId}
                    onChange={this.updatePokemonId}></input>

                <Button color="warning" onClick={this.findNewPokemon}>Find</Button>

                <br/>
                <h3>Name: {this.state.pokemon && this.state.pokemon.name}</h3>
                {this.getSprites()}

            </div>
        );
    }
}
