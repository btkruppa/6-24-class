import { connectionPool } from '../util/connection.util';
import { PoolClient } from 'pg';
import { Game } from '../models/game';


export async function findAll() {
    console.log('finding all users');
    let client: PoolClient;
    try {
        client = await connectionPool.connect(); // basically .then is everything after this
        const result = await client.query('SELECT * FROM game');
        // convert result from sql object to js object
        return result.rows.map(sqlGame => new Game(sqlGame.game_id, sqlGame.game_name, sqlGame.producer));
    } catch (err) {
        console.log(err);
    } finally {
        client && client.release();
    }
    console.log('found all');
    return undefined;
}
