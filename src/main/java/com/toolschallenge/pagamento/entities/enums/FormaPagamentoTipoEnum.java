package com.toolschallenge.pagamento.entities.enums;

public enum FormaPagamentoTipoEnum {

    AVISTA(1),
    PARCELADO_LOJA(2),
    PARCELADO_EMISSOR(3);

    private int code;

    private FormaPagamentoTipoEnum(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static FormaPagamentoTipoEnum valueOf(int code){

        for(FormaPagamentoTipoEnum value : FormaPagamentoTipoEnum.values()){
            if(value.getCode() == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid FormaPagamentoTipoEnum");
    }
    
}
