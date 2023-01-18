import Repository.TodoListRepository;
import Repository.TodoListRepositoryiImpl;
import View.TodoListView;
import service.TodoListService;
import service.TodoListServiceimpl;

public class ApplikasiTodoListV2 {
    public static void main(String[] args) {
        TodoListRepository todoListRepository=new TodoListRepositoryiImpl();
        TodoListService todoListService=new TodoListServiceimpl(todoListRepository);
        TodoListView todoListView=new TodoListView(todoListService);
        todoListView.showTodoListview();
    }
}
