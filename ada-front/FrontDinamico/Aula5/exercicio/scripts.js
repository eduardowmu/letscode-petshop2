const h1 = document.getElementById('resposta')

const ehNumeroPrimo = (numero) => {
    return new Promise((resolve, reject) => {
        if(!ehPrimo(numero)) {
            reject(`${numero} não é primo`)
        } else {
            resolve(`${numero} é primo! Parabéns!`)
        }
    })
}

const botao = document.querySelector(`button`)
botao.addEventListener(`click`, async () => {
    const input = document.querySelector(`input`)
    h1.innerText = ''
    ehNumeroPrimo(Math.floor(Math.random() * 10))
     .then((respostaEsperada) => {
        setTexto(respostaEsperada, 'green')
        /*
        const fonte = document.createElement("font")
        fonte.setAttribute('color', 'green')
        h1.insertAdjacentElement('afterbegin', fonte)
        fonte.innerText = respostaEsperada
        */
     })
     .catch((respostaFrustrante) => {
        setTexto(respostaFrustrante, 'red')
        /*
        const fonte = document.createElement("font")
        fonte.setAttribute('color', 'red')
        h1.insertAdjacentElement('afterbegin', fonte)
        fonte.innerText = respostaFrustrante
        */
     })
})

function ehPrimo(numero, color) {
    if(numero == 0) {
        return false
    }
    for(let i = 2; i < numero; i++) {
        if(numero % i == 0) {
            return false
        } 
    }
    return true
}

function setTexto(texto, color) {
    const fonte = document.createElement("font")
    fonte.setAttribute('color', color)
    h1.insertAdjacentElement('afterbegin', fonte)
    fonte.innerText = texto
}