package com.toolschallenge.pagamento.entities.enums;

public enum DescricaoStatusEnum {

    AUTORIZADO(1),
    NEGADO(2),
    CANCELADO(3);

    private int code;

    private DescricaoStatusEnum(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static DescricaoStatusEnum valueOf(int code){

        for(DescricaoStatusEnum value : DescricaoStatusEnum.values()){
            if(value.getCode() == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid DescricaoStatusEnum");
    }

}
