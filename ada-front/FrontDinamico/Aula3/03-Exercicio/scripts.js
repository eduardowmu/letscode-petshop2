const input = document.getElementById('entrada')

const paragraphs = document.getElementById('saida')

function verificaNumero() {
    paragraphs.innerText = ''
    const numero = Number(input.value)
    if(Number.isNaN(numero)) {
        paragraphs.append("Você não digitou um número")
    } else {
        paragraphs.append(numero % 2 > 0 ? "Este número é impar" : "Este número é par")
    }
    input.value = ""
}