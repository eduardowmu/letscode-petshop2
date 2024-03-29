import { loginService } from "../services/auth.service.js"
import { Header } from "../components/header.component.js"

const login = document.createElement('form')
login.setAttribute('id', 'p-login')

const eventos = () => {
    login.addEventListener('submit', (e) => {
        e.preventDefault()

        const fd = new FormData(login)
        const dadosDoFormulario = Object.fromEntries(fd)

        loginService(dadosDoFormulario)
            .then(({ data }) => {
                const { token, ...dadosUsuario } = data
                window.sessionStorage.setItem('@token', token)
                window.sessionStorage.setItem('@user', JSON.stringify(dadosUsuario))
                window.location.href = '/#contacts'

            })
            .catch((erro) => {
                console.log(erro)
            })
    })
}

export const Login = () => {

    const root = document.querySelector('#root')
    const componenteHeader = Header()
    root.append(componenteHeader)

    login.innerHTML = `
        <label for="email">E-mail</label>
        <input type="email" name="email">
        <label for="senha">Senha</label>
        <input type="password" name="senha">
        <fieldset>
            <input type="checkbox" name="salvar" id="salvar"  value="salvar">
            <label for="salvar">Salvar login?</label>
        </fieldset>
        <button type="submit">Entrar</button>
        <br>
        <p>
            Não tem conta? <a href="/#signup">crie aqui</a>
        </p>
    `

    eventos()
    return login
}


{/* <fieldset>
<label for="salvar">Salvar</label>
<input type="radio" name="salvar-senha" id="salvar" value="salvar">
<label for="nao-salvar">Não salvar</label>
<input type="radio" name="salvar-senha" id="nao-salvar" value="não salvar">
</fieldset> */}