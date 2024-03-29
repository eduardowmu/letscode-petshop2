const input = document.getElementById('entrada')

const tabela = document.getElementById('tabela')

const tarefas = document.getElementsByClassName('tarefa')

function inserirTarefa() {
    const entrada = input.value
    const qtd = tarefas.length
    
    tabela.insertAdjacentHTML('afterbegin', '<tbody id="' + (qtd + 1) + 
                                '" class="tarefa"><tr><td>' + entrada + 
                                '</td><td><button onclick="deletarTarefa('+ 
                                (qtd + 1) +')">Delete</button></td></tbody>')
    
    input.value = ''
}

function deletarTarefa(id) {
    const tarefa = document.getElementById(id)
    if(tarefa != undefined || tarefa != null) {
        tarefa.remove()
    }
}

function excluirTarefas() {
    let lista = document.getElementsByClassName('tarefa')
    let elementos = []
    const tamanho = lista.length
    for(let i = 0; i < tamanho; i++) {
        elementos.push(lista[i])
        console.log(elementos[i])
    }

    elementos.forEach(e => e.remove())
}