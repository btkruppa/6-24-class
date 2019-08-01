import { combineReducers } from "redux";
import clickerReducer from "./clicker.reducer";
import pokemonReducer from "./pokemon.reducer";


export interface IClickerState {
    clicks: number
}

export interface IPokemonState {
    pokemonName?: string,
    pokemonSprites?: any
}

// compose IState of all the other pieces of the state store
export interface IState {
    clicker: IClickerState,
    pokemon: IPokemonState
}

export const state = combineReducers<IState>({
    clicker: clickerReducer,
    pokemon: pokemonReducer
})