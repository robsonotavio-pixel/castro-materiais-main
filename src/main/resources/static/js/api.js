const API_BASE = '/api';

async function  apiGet(caminho) {
    const resposta = await fetch(API_BASE + caminho);
    if (!resposta.ok) throw new Error('Erro ao buscar dados');
    return resposta.json();
    
}

async function apiPost(caminho, dados) {
    const resposta = await fetch(API_BASE + caminho, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dados)
    });
    if (!resposta.ok) throw new Error('Erro ao salvar dados');
    return resposta.json();
}
 
async function apiPut(caminho,dados) {

    const resposta = await fetch(API_BASE + caminho,{
        method: 'PUT',
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify(dados)
    });
    if (!resposta.ok) throw new Error( 'Erro ao atualizar dados');
    return resposta.json();
    
}
async function  apiDelete(caminho) {
    const resposta = await fetch(API_BASE + caminho, {method: 'DELETE'});
    if(!resposta.ok) throw new Error('Error ao excluir dados');
    
}