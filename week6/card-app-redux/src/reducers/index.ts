import { combineReducers } from "redux";
import clickerReducer from "./clicker.reducer";


export interface IClickerState {
    clicks: number
}

// compose IState of all the other pieces of the state store
export interface IState {
    clicker: IClickerState
}

export const state = combineReducers<IState>({
    clicker: clickerReducer
})