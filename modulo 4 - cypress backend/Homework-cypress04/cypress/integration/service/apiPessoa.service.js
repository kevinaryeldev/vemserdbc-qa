const API_BASE = Cypress.env('API_BASE')
import Ajv from "ajv"
const ajv = new Ajv({allErrors:true,verbose: true})

export default class Contrato{
    static contratoRequest(contrato,endPoint){
        cy.request({
            failOnStatusCode:false,
            url:`${API_BASE}/${endPoint}`,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        }).then(response =>{
            cy.fixture(contrato).then((contrato)=>{
                const validate = ajv.compile(contrato)
                const responseApi = validate(response.body)
                if(!responseApi) cy.log(validate.errors).then(()=>{
                    throw new Error('Falha do contrato')
                })
            })
        })
    }
}