// https://github.com/dkayke-aulas/agenda-contatos-backend
const dados = {
    nome: "Ada Lovelace",
    email: "ada@email.com",
    telefones: [
        { 
            numero: "(11) 99123-4567",
            tipo: "celular"
        }
    ],
    endereco: {
        logradouro: "Rua das programadoras",
        cidade: "Vale do silício",
        estado: "Codefornia",
        cep: "10100-100",
        pais: "Programaland"
    }
}

const inputs = document.getElementsByClassName('texto')

inputs[0].value = dados.nome
inputs[1].value = dados.email
inputs[2].value = dados.telefones[0].numero
inputs[3].value = dados.endereco.logradouro
inputs[4].value = dados.endereco.cidade
inputs[5].value = dados.endereco.estado
inputs[6].value = dados.endereco.cep
inputs[7].value = dados.endereco.pais

inputs[0].addEventListener("change", function() {
    console.log(inputs[0].value)
})