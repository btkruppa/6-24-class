
export const pokemonTypes = {
    UPDATE: '[POKEMON] UPDATE'
}

export const updatePokemon = (pokemon: any) => {
    return {
        type: pokemonTypes.UPDATE,
        payload: pokemon
    }
}