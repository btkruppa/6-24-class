import { combineReducers } from "redux";
import clickerReducer from "./clicker.reducer";
import pokemonReducer from "./pokemon.reducer";
import User from "../models/user";
import authReducer from "./auth.reducer";


export interface IAuthState {
    currentUser?: User,
    errorMessage?: string
}

export interface IClickerState {
    clicks: number
}

export interface IPokemonState {
    pokemonName?: string,
    pokemonSprites?: any
}

// compose IState of all the other pieces of the state store
export interface IState {
    auth: IAuthState,
    clicker: IClickerState,
    pokemon: IPokemonState
}

export const state = combineReducers<IState>({
    auth: authReducer,
    clicker: clickerReducer,
    pokemon: pokemonReducer
})