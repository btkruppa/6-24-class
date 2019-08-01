import { connectionPool } from '../util/connection.util';
import { PoolClient } from 'pg';
import { convertSqlUser } from '../util/user.converter';
import User from '../models/user';


export async function findAll() {
    console.log('finding all users');
    let client: PoolClient;
    try {
        client = await connectionPool.connect(); // basically .then is everything after this
        const result = await client.query('SELECT * FROM app_user');
        // convert result from sql object to js object
        return result.rows.map(convertSqlUser);
    } catch (err) {
        console.log(err);
    } finally {
        client && client.release();
    }
    console.log('found all');
    return undefined;
}

export async function findById(id: number) {
    console.log('finding user by id: ' + id);
    let client: PoolClient;
    try {
        client = await connectionPool.connect(); // basically .then is everything after this
        const result = await client.query('SELECT * FROM app_user WHERE user_id = $1', [id]);
        const sqlUser = result.rows[0];
        return sqlUser && convertSqlUser(sqlUser);
    } catch (err) {
        console.log(err);
    } finally {
        client && client.release();
    }
    return undefined;
}


export async function findByFirstName(firstName: string) {
    console.log('finding users by first name');
    let client: PoolClient;
    try {
        client = await connectionPool.connect(); // basically .then is everything after this
        const result = await client.query('SELECT * FROM app_user WHERE first_name = $1', [firstName]);
        return result.rows.map(convertSqlUser);
    } catch (err) {
        console.log(err);
    } finally {
        client && client.release();
    }
    return undefined;
}



export async function findByUsernameAndPassword(username: string, password: string) {
    let client: PoolClient;
    try {
        client = await connectionPool.connect();

        // it is bad to use interpolation here because it allows sql injection
        // const queryString = `
        //     SELECT * FROM app_user
        //         WHERE username = '${username}' AND pass = '${password}'
        // `;

        // instead there is a built in way of handling this to prevent sql injection
        const queryString = `
            SELECT * FROM app_user
                WHERE username = $1 AND pass = $2
        `;
        const result = await client.query(queryString, [username, password]);
        const sqlUser = result.rows[0]; // there should really only be 1 row at best
        return sqlUser && convertSqlUser(sqlUser);
    } catch (err) {
        console.log(err);
    } finally {
        client && client.release();
    }
    return undefined;
}

export async function save(user: User) {
    let client: PoolClient;
    try {
        client = await connectionPool.connect(); // basically .then is everything after this
        const queryString = `
            INSERT INTO app_user (username, pass, first_name, last_name, phone, email, role)
            VALUES 	($1, $2, $3, $4, $5, $6, $7)
            RETURNING user_id
        `;
        const params = [user.username, user.password, user.firstName, user.lastName, user.phone, user.email, user.role];
        const result = await client.query(queryString, params);
        return result.rows[0].user_id;
    } catch (err) {
        console.log(err);
    } finally {
        client && client.release();
    }
    console.log('found all');
    return undefined;
}

export async function update(user: Partial<User>) {
    const oldUser = await findById(user.id);
    if (!oldUser) {
        return undefined;
    }
    user = {
        ...oldUser,
        ...user
    };
    console.log(user);
    let client: PoolClient;
    try {
        client = await connectionPool.connect(); // basically .then is everything after this
        const queryString = `
            UPDATE app_user SET username = $1, pass = $2, first_name = $3, last_name = $4, phone = $5, email = $6, role = $7
            WHERE user_id = $8
            RETURNING *
        `;
        const params = [user.username, user.password, user.firstName, user.lastName, user.phone, user.email, user.role, user.id];
        const result = await client.query(queryString, params);
        const sqlUser = result.rows[0];
        return convertSqlUser(sqlUser);
    } catch (err) {
        console.log(err);
    } finally {
        client && client.release();
    }
    console.log('found all');
    return undefined;
}
