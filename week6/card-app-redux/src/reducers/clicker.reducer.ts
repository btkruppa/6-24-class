import { IClickerState } from ".";
import { clickerTypes } from "../actions/clicker.actions";

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
        default:
            return state
    }
}
