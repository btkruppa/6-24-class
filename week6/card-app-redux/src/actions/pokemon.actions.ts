import Axios from "axios";

export const pokemonTypes = {
    UPDATE: '[POKEMON] UPDATE'
}

export const updatePokemon = (id: any) => async (dispatch: any) => {
    const resp = await Axios.get('https://pokeapi.co/api/v2/pokemon/' + id);
    const pokemon = resp.data;
    dispatch({
        type: pokemonTypes.UPDATE,
        payload: pokemon
    });
}