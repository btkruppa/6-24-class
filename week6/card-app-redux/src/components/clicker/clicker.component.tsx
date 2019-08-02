import React from 'react';
import ClickerDisplay from './clicker-display/clicker-display.component';
import ClickerIncrementer from './clicker-incrementer/clicker-incrementer.component';
import { IState, IClickerState } from '../../reducers';
import { connect } from 'react-redux';
import { updateClicks } from '../../actions/clicker.actions';


export interface IClickerProps {
    clicker: IClickerState,
    updateClicks: (amount: number) => any
}

export class Clicker extends React.Component<IClickerProps> {

    increment = (amount: number) => {
        this.props.updateClicks(amount);
    }

    render() {
        const { clicks } = this.props.clicker;
        return (
            <div>
                <ClickerDisplay clicks={clicks} />
                <ClickerIncrementer amount={3} clicks={clicks}
                    increment={this.increment} renderAt={0} />

                <ClickerIncrementer amount={4} clicks={clicks}
                    increment={this.increment} renderAt={36} />

                <ClickerIncrementer amount={5} clicks={clicks}
                    increment={this.increment} renderAt={40} />

                <ClickerIncrementer amount={1000} clicks={clicks}
                    increment={this.increment} renderAt={100} />
            </div>
        );
    }
}

const mapStateToProps = (state: IState) => {
    return {
        clicker: state.clicker
    }
}

const mapDispatchToProps = {
    updateClicks
}

// Connect our component to the redux store, watch out where you
// import the componet into, and make sure you use this default export
export default connect(mapStateToProps, mapDispatchToProps)(Clicker);