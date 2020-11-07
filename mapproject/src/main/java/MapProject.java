import vo.EmployeePK;
import vo.EmployeeVO;

import java.util.HashMap;

public class MapProject {



    public static void main(String[] args) {


        HashMap<EmployeePK, EmployeeVO> hashpk = new HashMap<>();

        EmployeePK employeePK1 = new EmployeePK(1,101);
        EmployeeVO employeeVO1 = new EmployeeVO(1,101, "HSW", "CEO");
        hashpk.put(employeePK1,employeeVO1);

        EmployeePK employeePK2 = new EmployeePK(2,101);
        EmployeeVO employeeVO2 = new EmployeeVO(2,101, "HSY", "CTO");
        hashpk.put(employeePK2,employeeVO2);

        EmployeePK employeePK3 = new EmployeePK(1,301);
        EmployeeVO employeeVO3 = new EmployeeVO(1,301, "HSW", "TEACHER");
        hashpk.put(employeePK3,employeeVO3);

        EmployeePK employeePK4 = new EmployeePK(1,101);
        EmployeeVO employeeVO4 = new EmployeeVO(1,101, "철수", "개발자");
        hashpk.put(employeePK4,employeeVO4);


        System.out.println(hashpk);
        System.out.println(hashpk.size()); // pk가 같은 값을 주어


        /**
        * 내가 해보고 싶은것
        * 프로젝트내에서 19만개의 이기종의 디비의 각 로우를 실시간으로 확인하고 동기화 해야 하는 잡을 수행해야 했다.
        * 물론 db내에서 insert duplicate on update 를 사용 해도 되지만
        * 이방법으로 19만개를 돌리려면 3~5분정도의 시간이 필요하였다,
        * 그래서 조금더 좋은 방법이 없을까 하다
        * map을 사용하여
        * pk가 같은 값은 내용을 비교하고
        * pk가 없는 값은 값을 추가하면 db내에서 19만*19만 정도의 연산을 할 필요가 없지 않을가 싶었다.
        * */


        HashMap<EmployeePK, EmployeeVO> hashpk2 = new HashMap<>();

        // 여기서 바뀐건 CEO HSW가 빠지고 철수가 들어온것이다. 이걸 어떻게 확인할 수 있을까?

        hashpk2.put(employeePK4,employeeVO1);
        hashpk2.put(employeePK2,employeeVO2);
        hashpk2.put(employeePK3,employeeVO3);

        for (EmployeePK employeePK : hashpk2.keySet()){
            if(hashpk.containsKey(employeePK)){
                if(hashpk2.get(employeePK).equals(hashpk.get(employeePK))){
                    System.out.println(employeePK);
                }
            }
        }


    }

}
