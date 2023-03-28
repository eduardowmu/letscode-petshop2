const formLogin = document.querySelector('[name="login"]')

formLogin.addEventListener('submit', (evento) => {
    evento.preventDefault()

    // const inputSalvar = document.querySelector('#salvar')
    // console.log(inputSalvar.value)

    // const form = document.forms.login
    // console.log(form.usuario.value)
    // console.log(form.senha.value)

    const fd = new FormData(formLogin)

    const salvarSenha = fd.get('salvar-senha')
    fd.append('salvarsenha', salvarSenha)

    fd.delete('salvar-senha')
    
    const entradas = Object.fromEntries(fd)
    
    console.log(entradas)

    for(let entradas of fd) {
        // console.log(`o valor do campo ${entradas[0]} é igual a ${entradas[1]}`)
    }

})


// const submeter = () => {
//     console.log('SUBMETEU MEU FORM!')
// }