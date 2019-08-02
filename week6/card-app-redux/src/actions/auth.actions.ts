import { cardClient } from "../axios/card.client";

export const authTypes = {
    UPDATE_CURRENT_USER: '[AUTH] UPDATE CURRENT USER',
    FAILED_LOGIN: '[AUTH] FAILED LOGIN'
}

export const login = (credentials: any, history: any) => async (dispatch: any) => {
    try {
        const resp = await cardClient.post('/login', credentials);
        const user = resp.data;
        console.log(user);

        dispatch({
            type: authTypes.UPDATE_CURRENT_USER,
            payload: user
        })
        history.push('/cards'); // navigate pages
    } catch (err) {
        console.log(err);
        console.log('invalid credentials');
        dispatch({
            type: authTypes.FAILED_LOGIN,
            payload: 'Invalid Credentials'
        });
    }
}