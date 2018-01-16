package lab.zlren.house.test.bean;

import lab.zlren.house.common.utils.BeanHelper;

/**
 * @author zlren
 * @date 2018-01-16
 */
public class BeanHelperTest {

    public static void main(String[] args) {
        Student student = new Student();
        BeanHelper.setDefaultProp(student, Student.class);
        System.out.println("哈哈" + student.getName());
        System.out.println(student.getScore());
    }

}
