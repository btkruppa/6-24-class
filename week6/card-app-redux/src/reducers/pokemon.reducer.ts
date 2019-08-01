import { IPokemonState } from ".";
import { pokemonTypes } from "../actions/pokemon.actions";

const initialState: IPokemonState = {
    pokemonName: 'pikachu'
}

export default (state = initialState, action: any): IPokemonState => {
    switch (action.type) {

        case pokemonTypes.UPDATE:
            return {
                ...state,
                pokemonName: action.payload.name,
                pokemonSprites: action.payload.sprites
            }

        default:
            return state
    }
}
