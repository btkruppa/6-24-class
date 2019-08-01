import React from 'react';
import { Button } from 'reactstrap';
import { IPokemonState, IState } from '../../reducers';
import { connect } from 'react-redux';
import { updatePokemon } from '../../actions/pokemon.actions';

interface IComponentState {
    pokemonId: number
}

interface IProps {
    pokemon: IPokemonState,
    clicks: number,
    updatePokemon: (id: number) => any
}

export class Pokemon extends React.Component<IProps, IComponentState> {

    constructor(props: any) {
        super(props);
        this.state = {
            pokemonId: 7
        }
    }

    updatePokemonId = (event: React.ChangeEvent<HTMLInputElement>) => {
        this.setState({
            pokemonId: +event.target.value
        })
    }

    findNewPokemon = async () => {
        this.props.updatePokemon(this.state.pokemonId);
    }

    getSprites = () => {
        if(!this.props.pokemon.pokemonSprites) {
            return [];
        }
        const spritesTSX: any[] = []
        const sprites = this.props.pokemon.pokemonSprites
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

                <Button color="warning" 
                    onClick={this.findNewPokemon}
                    disabled={this.props.clicks < 15}>
                    Find
                </Button>

                <br/>
                <h3>Name: {this.props.pokemon && this.props.pokemon.pokemonName}</h3>
                {this.getSprites()}

            </div>
        );
    }
}

const mapStateToProps = (state: IState) => ({
    pokemon: state.pokemon,
    clicks: state.clicker.clicks
})

const mapDispatchToProps = {
    updatePokemon
}

export default connect(mapStateToProps, mapDispatchToProps)(Pokemon)