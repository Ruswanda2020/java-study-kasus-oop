package Repository;

import Entity.TodoList;

public class TodoListRepositoryiImpl implements TodoListRepository{

    private TodoList [] data =new TodoList[10];
    @Override
    public TodoList[] getAll() {
        return data;
    }

    public Boolean isfull(){
        //cek apakah data apakah penuh?
        var isfull=true;
        for (var i=0;i< data.length;i++) {
            if (data[i] == null) {
                //data masih ada yang kosong
                isfull = false;
            }
        }
        return isfull;
    }
    public void resizeIfFull(){
        //jika array sudah penuh maka resize ukuranyah 2*lipat
        if (isfull()){
            var temp=data;
            data= new TodoList[data.length * 2];

            for (var i=0;i<temp.length;i++){
                data[i]=temp[i];
            }
        }
    }
    @Override
    public void add(TodoList todoList) {
        resizeIfFull();
        //tambahkan ke posisi yang data arraynyah null
        for (var i=0;i< data.length;i++){
            if (data[i]==null){
                data[i]=todoList;
                break;
            }
        }
    }
    @Override
    public boolean remove(Integer number) {
        if ((number-1) >= data.length){
           return false;
        } else if (data[number-1]==null) {
            return false;
        }else {
            for (var i=(number-1); i < data.length;i++){
                if (i==(data.length-1)){
                    data[i]=null;
                }else {
                    data[i]=data[i+1];
                }
            }
            return true;
        }

    }
}
