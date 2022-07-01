function inserirResultado(){
    
    const valorGasto = parseFloat(document.getElementById('floatingInputValorGasto').value)
    
    const valorInserido = parseFloat(document.getElementById('floatingInputValorInserido').value)
    
    const inputResultado = document.getElementById('floatingInputResultado')
    
    const resultado = valorInserido - valorGasto  


    inputResultado.value = resultado
}
    window.addEventListener('load', inserirResultado)