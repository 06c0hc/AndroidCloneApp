package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //로또 번호 리스트
        val lotteryNumbers = arrayListOf<TextView>(findViewById(R.id.FirstBall),findViewById(R.id.SecondBall),findViewById(R.id.ThirdBall),findViewById(R.id.FourthBall),findViewById(R.id.FifthBall),findViewById(R.id.SixthBall))

        //3초를 세는 타이머 생성
        //3초동안 0.1초마다 특정작업을 수행
        val countDownTimer = object : CountDownTimer(3000, 100){
            //countDownInterval 마다 로또번호를 생성함
            override fun onTick(p0: Long) {
                lotteryNumbers.forEach {
                    val randNumber = (Math.random() * 45 + 1).toInt()
                    it.text = "$randNumber"
                }
            }

            override fun onFinish() {

            }

        }
        //버튼 클릭시 로또 번호 생성, 애니메이션 실행중 버튼을 누르면 중단
       val lotteryBtn = findViewById<LottieAnimationView>(R.id.LotteryButton)
        lotteryBtn.setOnClickListener {
            if(lotteryBtn.isAnimating){//애니메이션이 실행되고 있다면 애니메이션을 중단함
                lotteryBtn.cancelAnimation()
                countDownTimer.cancel()
            }else{//애니메이션이 실행되고 있지 않다면 애니메이션을 실행함
                lotteryBtn.playAnimation()
                countDownTimer.start()
            }
        }
    }
}