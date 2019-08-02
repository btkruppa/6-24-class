import React from 'react';
import { shallow } from 'enzyme';
import { Clicker, IClickerProps } from './clicker.component';
import ClickerDisplay from './clicker-display/clicker-display.component';
import ClickerIncrementer from './clicker-incrementer/clicker-incrementer.component';

describe('<Clicker />', () => {

    let mockProps: IClickerProps;

    beforeEach(() => {
        mockProps = {
            clicker: {
                clicks: 0
            },
            updateClicks: jest.fn()
        }
    })

    it('Should render a <ClickerDisplay />', () => {
        const clicker = shallow(<Clicker {...mockProps} />);
        const display = clicker.find(ClickerDisplay); // find the display
        expect(display).toHaveLength(1); // ensure that exactly 1 display was found
    })

    it('Should render 4 clicker incrementers', () => {
        const testClickValues = [0,1,2,52,235,232532,325125];
        testClickValues.forEach(value => {
            mockProps.clicker.clicks = value;
            const clicker = shallow(<Clicker {...mockProps} />);
            const incrementers = clicker.find(ClickerIncrementer);
            expect(incrementers).toHaveLength(4);
        })
    })

})