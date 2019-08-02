import React from 'react'
import { Button } from 'reactstrap';

export  interface IClickerIncrementerProps {
    clicks: number,
    renderAt: number,
    amount: number,
    increment: (amount: number) => void
}

export default function ClickerIncrementer(props: IClickerIncrementerProps) {
    const {renderAt, clicks, amount, increment } = props;
    if(clicks < renderAt) {
        return null;
    }  else {
        return (
            <Button color="success" onClick={() => increment(amount)}>+{amount}</Button>
        )
    }
}
