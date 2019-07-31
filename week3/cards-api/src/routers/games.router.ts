import express from 'express';

import * as gameDao from '../daos/sql-game.dao';

export const gamesRouter = express.Router();

gamesRouter.get('', async (req, res) => {
    const games = await gameDao.findAll();
    res.json(games);
});
