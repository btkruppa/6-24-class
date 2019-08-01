
export const clickerTypes = {
    UPDATE: '[CLICKER] UPDATE'
}

export const updateClicks = (amount: number) => {
    return {
        type: clickerTypes.UPDATE,
        payload: amount
    }
}