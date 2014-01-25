s.boot;

(
SynthDef( \noise , {|out = 0, freq, dur,  amp=0.25, pink = 100, pan = 0|

	var env, sound, panner;

	sound =  PinkNoise.ar(freq)*(SinOsc.ar(freq)+SinOsc.ar(freq*2)+0.3*SinOsc.ar(freq*3)+0.2*SinOsc.ar(freq*4)+SinOsc.ar(freq*5));

	env = EnvGen.kr(Env.adsr(dur/100 , dur/2, 0, 0, amp,0 ), doneAction:2);

	panner = Pan2.ar(sound , pan , env);
	
	Out.ar(out, panner);
}).store
)


(
 SynthDef(\balafon, {|out = 0, freq, amp, dur, pan = 0, mod = 50|
  
  //variaveis
  var pm, modulator, env, panner;
  
  //gerador da modulacao
  modulator = SinOsc.ar(mod, 0, 0.2);
  //modulacao
  pm = SinOsc.ar(freq, modulator);
  
  //gerador do envelope
  env = EnvGen.kr(Env.perc(0.01, dur, amp), doneAction:2);
  //gerador do pan
  panner = Pan2.ar(pm, pan, env);
  
  Out.ar(out, panner);
 }).store
)

(
c= Pbind(
    \instrument, \noise,
    \freq , Prand([110,770,880,220,660,300,60,110,50,770,440,880,120,1000,990,1200,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],inf),
    \dur , Pwhite(0.02,0.9),
    \amp, Pwhite(0.0002, 0.003),
    \pan, Prand([0,1],inf)
).play

)
c.stop;


(
d = Pbind ( 
    \instrument, \balafon,
    \freq , Prand([65.4, 73,41, 77.78 , 82.40, 92.49, 98, 110, 116.54,130.81, 146.83, 155.56, 164.81,185, 195.99, 220 ],200),
    \amp, Pwhite(0.1,0.6),
    \dur, Pwhite(0.5,2)
    ).play
)

)


(

e = Pbind ( 
    \instrument, \balafon,
    \freq , Prand([65.4, 73,41, 77.78 , 82.40, 92.49, 98, 110, 116.54,130.81, 146.83, 155.56, 164.81,185, 195.99, 220,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 ]*5,500),
    \amp, Pwhite(0.01,0.7),
    \dur, Pwhite(0.1,1.2)
    ).play
)

)
e.stop;
