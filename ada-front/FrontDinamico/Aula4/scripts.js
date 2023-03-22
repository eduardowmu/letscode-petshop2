const input = document.getElementById('entrada')

const tabela = document.getElementById('tabela')

const tarefas = document.getElementsByClassName('tarefa')

function inserirTarefa() {
    const entrada = input.value
    let qtd = tarefas.length
    tabela.insertAdjacentHTML('afterbegin', '<tbody id="' + (qtd + 1) + 
                                '" class="tarefa"><tr><td>' + entrada + 
                                '</td><td><button onclick="deletarTarefa('+ 
                                (qtd + 1) +')">Delete</button></td></tbody>')
    
    input.value = ''
}

function deletarTarefa(id) {
    const tarefa = document.getElementById(id)
    tarefa.remove()
}

function excluirTarefas() {
    const lista = tarefas.length
    for(let i = 0; i < lista; i++) {
        deletarTarefa(i+1)
    }
}