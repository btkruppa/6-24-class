import { IClickerState } from ".";
import { clickerTypes } from "../actions/clicker.actions";
import { pokemonTypes } from "../actions/pokemon.actions";

const initialState: IClickerState = {
    clicks: 25
}

export default (state = initialState, action: any): IClickerState => {
    switch (action.type) {
        case clickerTypes.UPDATE:
            return {
                ...state,
                clicks: state.clicks + action.payload
            }
        case pokemonTypes.UPDATE :
            return {
                ...state,
                clicks: state.clicks - 15
            }
        default:
            return state
    }
}
