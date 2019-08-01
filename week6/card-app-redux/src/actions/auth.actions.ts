import { environment } from "../environment";

export const authTypes = {
    UPDATE_CURRENT_USER: '[AUTH] UPDATE CURRENT USER',
    FAILED_LOGIN: '[AUTH] FAILED LOGIN'
}

export const login = (credentials: any, history: any) => async (dispatch: any) => {
    try {
        const resp = await fetch(environment.context + '/login', {
            method: 'POST',
            credentials: 'include',
            body: JSON.stringify(credentials),
            headers: {
                'content-type': 'application/json'
            }
        });
        const user = await resp.json();
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