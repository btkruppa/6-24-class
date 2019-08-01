import express from 'express';
import * as cardDao from '../daos/sql-card.dao';
import { authMiddleware } from '../middleware/auth.middleware';

export const cardsRouter = express.Router();

/**
 * /cards
 * Find all cards
 */
cardsRouter.get('', [
    authMiddleware('admin'),
    async (req, res) => {
    const cards = await cardDao.findAll();
    res.json(cards);
}]);

/**
 * /cards
 * Find all cards by game
 */
cardsRouter.get('/game/:gameId', async (req, res) => {
    const gameId = +req.params.gameId;
    const cards = await cardDao.findByGameId(gameId);
    res.json(cards);
});

/**
 * /cards/game/:game
 * find cards by game
 */
cardsRouter.get('/game/:game', (req, res) => {
    res.send(`finding cards by game: ${req.params.game}`);
});


/**
 * /cards/:id
 * find cards by id
 */
cardsRouter.get('/:id', (req, res) => {
    res.send(`finding cards by id: ${req.params.id}`);
});

/**
 * /cards/owner/:ownerId
 * find cards by owner's id
 */
cardsRouter.get('/owner/:ownerId', (req, res) => {
    res.send(`finding cards by owner's id: ${req.params.ownerId}`);
});


/**
 * /cards
 * create new card resource
 */
cardsRouter.post('', async (req, res) => {
    const card = req.body;
    if (!card) {
        res.sendStatus(400);
    } else {
        const id = await cardDao.save(card);
        if (!id) {
            res.sendStatus(400);
        } else {
            card.id = id;
            res.status(201); // created status code
            res.json(card);
        }
    }
});

/**
 * /cards
 * partially update card resource
 */
cardsRouter.patch('', (req, res) => {
    res.send(`updating card: ${JSON.stringify(req.body)}`);
});

/**
 * /cards
 * delete card by id
 */
cardsRouter.delete('/:id', (req, res) => {
    console.log(`deleting card with id: ${req.params.id}`);
    res.send(`deleting card with id: ${req.params.id}`);
});