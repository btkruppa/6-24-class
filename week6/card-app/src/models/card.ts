import { Quality } from './quality';
import User from './user';
import { Game } from './game';

export default class Card {
    constructor(
        public id = 0,
        public name = '',
        public value = 0,
        public quality: Quality,
        public owner: User,
        public game: Game
    ) {}
}