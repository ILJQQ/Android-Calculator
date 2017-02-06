package com.jikexueyuan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*申明变量*/
    private double result;
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, add, divide,
            times, minus, equals, cancel;
    private TextView tvResult;
    private double firNum, secNum;
    private String myString;
    private String operation;
    private boolean equClicked = false;
    private String strResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        为变量赋值
        initialize();
//        为按键设置按压监听器
        setListener();
    }

    /*将各变量与对应的按钮链接起来*/
    private void initialize() {
        num0 = (Button) findViewById(R.id.btnNum0);
        num1 = (Button) findViewById(R.id.btnNum1);
        num2 = (Button) findViewById(R.id.btnNum2);
        num3 = (Button) findViewById(R.id.btnNum3);
        num4 = (Button) findViewById(R.id.btnNum4);
        num5 = (Button) findViewById(R.id.btnNum5);
        num6 = (Button) findViewById(R.id.btnNum6);
        num7 = (Button) findViewById(R.id.btnNum7);
        num8 = (Button) findViewById(R.id.btnNum8);
        num9 = (Button) findViewById(R.id.btnNum9);
        add = (Button) findViewById(R.id.btnAdd);
        minus = (Button) findViewById(R.id.btnMinus);
        times = (Button) findViewById(R.id.btnTimes);
        divide = (Button) findViewById(R.id.btnDivide);
        cancel = (Button) findViewById(R.id.btnCancel);
        equals = (Button) findViewById(R.id.btnEquals);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    /*为各个按钮添加按压事件监听器*/
    private void setListener() {
        num0.setOnClickListener((View.OnClickListener) this);
        num1.setOnClickListener((View.OnClickListener) this);
        num2.setOnClickListener((View.OnClickListener) this);
        num3.setOnClickListener((View.OnClickListener) this);
        num4.setOnClickListener((View.OnClickListener) this);
        num5.setOnClickListener((View.OnClickListener) this);
        num6.setOnClickListener((View.OnClickListener) this);
        num7.setOnClickListener((View.OnClickListener) this);
        num8.setOnClickListener((View.OnClickListener) this);
        num9.setOnClickListener((View.OnClickListener) this);
        cancel.setOnClickListener((View.OnClickListener) this);
        add.setOnClickListener((View.OnClickListener) this);
        minus.setOnClickListener((View.OnClickListener) this);
        times.setOnClickListener((View.OnClickListener) this);
        divide.setOnClickListener((View.OnClickListener) this);
        equals.setOnClickListener((View.OnClickListener) this);
    }

    /*设置对应按钮监听到按压操作后的处理事项*/
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnNum0:
                //判断显示数字是否为计算答案新的输入将会清空显示框
                equClicked();
                myString = tvResult.getText().toString();
                myString += "0";
//              调用长度检测方法在输入超过八位数后缩小字体以显示更多数字
                checkLength(myString);
                tvResult.setText(myString);
                break;
            case R.id.btnNum1:
                equClicked();
                myString = tvResult.getText().toString();
                myString += "1";
                checkLength(myString);
                tvResult.setText(myString);
                break;
            case R.id.btnNum2:
                equClicked();
                myString = tvResult.getText().toString();
                myString += "2";
                checkLength(myString);
                tvResult.setText(myString);
                break;
            case R.id.btnNum3:
                equClicked();
                myString = tvResult.getText().toString();
                myString += "3";
                checkLength(myString);
                tvResult.setText(myString);
                break;
            case R.id.btnNum4:
                equClicked();
                myString = tvResult.getText().toString();
                myString += "4";
                checkLength(myString);
                tvResult.setText(myString);
                break;
            case R.id.btnNum5:
                equClicked();
                myString = tvResult.getText().toString();
                myString += "5";
                checkLength(myString);
                tvResult.setText(myString);
                break;
            case R.id.btnNum6:
                equClicked();
                myString = tvResult.getText().toString();
                myString += "6";
                checkLength(myString);
                tvResult.setText(myString);
                break;
            case R.id.btnNum7:
                equClicked();
                myString = tvResult.getText().toString();
                myString += "7";
                checkLength(myString);
                tvResult.setText(myString);
                break;
            case R.id.btnNum8:
                equClicked();
                myString = tvResult.getText().toString();
                myString += "8";
                checkLength(myString);
                tvResult.setText(myString);
                break;
            case R.id.btnNum9:
                equClicked();
                myString = tvResult.getText().toString();
                myString += "9";
                checkLength(myString);
                tvResult.setText(myString);
                break;
//          清零并调整字体
            case R.id.btnCancel:
                firNum = 0;
                secNum = 0;
                myString = "";
                tvResult.setTextSize(80);
                tvResult.setText(myString);
                break;

            /*调用运算符设置方法对符号输入进行判断在无数字情况下输入运算符错误提示*/
            case R.id.btnAdd:
                myString = tvResult.getText().toString();
                checkOperation(myString, "+");
                break;
            case R.id.btnMinus:
                myString = tvResult.getText().toString();
                checkOperation(myString, "-");
                break;
            case R.id.btnTimes:
                myString = tvResult.getText().toString();
                checkOperation(myString, "*");
                break;
            case R.id.btnDivide:
                myString = tvResult.getText().toString();
                checkOperation(myString, "/");
                break;

            /*等于按钮事件监听在不同情况下对输入进行判断检测了除数为零，未输入直接
            *按等号和单次数据输入直接按等号的情况并根据实例进行回馈
            * */
            case R.id.btnEquals:
                myString = tvResult.getText().toString();
                if (myString.isEmpty()) {
                    tvResult.setTextSize(40);
                    tvResult.setText("输入错误请先清零");
                } else {
                    secNum = Double.valueOf(myString);
                    equClicked = true;
                    if (secNum == 0 && operation.equals("/")) {
                        tvResult.setTextSize(40);
                        tvResult.setText("输入错误请先清零");
                    } else if (firNum == 0 || secNum == result) {
                        tvResult.setText(myString);
                    } else {
                        switch (operation) {
                            case "+":
                                result = firNum + secNum;
                                break;
                            case "-":
                                result = firNum - secNum;
                                break;
                            case "*":
                                result = firNum * secNum;
                                break;
                            case "/":
                                result = firNum / secNum;
                                break;
                            default:
                                break;
                        }
                        strResult = String.valueOf(result);
                        setInt(result);
                        checkLength(strResult);
                        tvResult.setText(strResult);
                    }
                }
                break;
            default:
                break;
        }
    }

    /*运算结果检测若本次输入前显示框内为运算结果将会清除结果并重设判断语句*/
    private void equClicked() {
        if (equClicked) {
            tvResult.setTextSize(80);
            tvResult.setText(null);
            equClicked = false;
        }
    }

    /*长度判断方法根据长度调整字体单排可显示长度为17位数最多显示长度为34位数*/
    private void checkLength(String str) {
        if (str.length() > 8 && str.length() < 16) {
            tvResult.setTextSize(40);
        } else if (str.length() > 15) {
            tvResult.setTextSize(34);
        }

    }

    /*判断是否在未输入情况下直接按运算符若有值则进行赋值并运算*/
    private void checkOperation(String str, String op) {
        if (str.isEmpty()) {
            tvResult.setTextSize(40);
            tvResult.setText("输入错误请先清零");
        } else {
            firNum = Double.valueOf(str);
            operation = op;
            tvResult.setText("");
        }
    }

    private void setInt(double aDouble){
        if (String.valueOf(aDouble).endsWith(".0")){
            int aInt = (int) aDouble;
            strResult = String.valueOf(aInt);
        }
    }
}
