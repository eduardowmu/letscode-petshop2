const express = require('express')
const app = express();
app.use(express.json())
app.use(express.urlencoded());

const users = [];

app.get('/users', (_, res) => res.send(users))
app.post('/users', (req, res) => {
    const { name, email, password } = req.body;
    const newUser = {
        name,
        email,
        password
    }
    users.push(newUser)

    return res.send();
})

app.listen(3000, () => console.log('server is running...'))
