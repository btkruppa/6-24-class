
export const pokemonTypes = {
    UPDATE: '[POKEMON] UPDATE'
}

export const updatePokemon = (id: any) => async (dispatch: any) => {
    const resp = await fetch('https://pokeapi.co/api/v2/pokemon/' + id);
    const pokemon = await resp.json();
    dispatch({
        type: pokemonTypes.UPDATE,
        payload: pokemon
    });
}