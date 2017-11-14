package event;

//�¼�����
public enum ProductEventType {
    //�½�һ����Ʒ
    NEW_PRODUCT(1),
    //ɾ��һ����Ʒ
    DEL_PRODUCT(2),
    //�޸�һ����Ʒ
    EDIT_PRODUCT(3),
    //��¡һ����Ʒ
    CLONE_PRODUCT(4);
    //panda �ɷ�����չ
    private int value=0;

    ProductEventType(int _value){
        this.value = _value;
    }
    public int getValue(){
        return this.value;
    }
}