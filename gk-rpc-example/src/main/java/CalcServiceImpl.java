/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 16:07
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class CalcServiceImpl implements CalcService{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }
}
