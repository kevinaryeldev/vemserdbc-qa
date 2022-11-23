/// <reference types="cypress" />

export default class BasePage {
   static click(elemet){ 
      cy.get(elemet).click() 
   }
  
   static clickForce(elemet){ 
      cy.get(elemet).click({force:true}) 
   } 
  
   static preencherInput(element, text){ 
      cy.get(element).clear()
      cy.get(element).type(text)
   }
   
   static limparInput(element){
      cy.get(element).clear()
   }

   static preencherInputComTeclaNoFinal(element, text, tecla){
      cy.get(element).type(text).type(tecla);
   }
  
   static preencherInputForce(element, text){ 
       cy.get(element).type(text, {force:true})
   }
    
   static tempo(tempo){ 
       cy.wait(tempo) 
   }

   static select(element, value){ 
      cy.get(element).select(value) 
   }
  
   static validarText(element, text){ 
      cy.get(element).should('contain', text) 
   }
  
   static validarQuantItemNaLista(element, quant){
      cy.get(element).should('have.length', quant)
   }

   static validarUrl(url){
      cy.url()
      .should('contain', url)
   }
}
  