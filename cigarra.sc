
s.boot;
s.quit;

(
SynthDef( \insect1 , {|out = 0, freq, dur,  amp=0.25, pink = 100, pan = 0|

	var env, mod,panner, sinsound;

	mod =  freq * PinkNoise.ar(pink);

	sinsound = SinOsc.ar ( mod ,0.2) + SinOsc.ar(freq*2,0,0.7); 
	
	env = EnvGen.kr(Env.triangle(dur , amp ), doneAction:2);

	panner = Pan2.ar(sinsound , pan , env);
	
	Out.ar(out, panner);
}).store
)


(
SynthDef ( \SinInsect, {|out = 0 , freq , harm1=3 ,harm2=7, dur , amp=0.25 , mod =  50 , pan=0|

    var modulation, env, sinsound, panner;
	modulation = SinOsc.ar( mod ,0, 0.2);
	sinsound = SinOsc.ar(freq,modulation)+Saw.ar(SinOsc.kr(mod/2),modulation)*0.05+SinOsc.ar(harm2*freq,0);
	env = EnvGen.kr(Env.adsr(dur/100, dur/2, 0 ,0,amp,0), doneAction:2);
	panner = Pan2.ar(sinsound , pan , env);
	
	Out.ar(out, panner);
}).store
)

(
 b = Pbind(
  \instrument, \insect1,
  \freq,  Pwhite(50,300),
  \pink , Pwhite(0.1,15),
  \dur, Pwhite(0.8,4),
  \pan, Pwhite(0,0.5), 
  \amp, Prand([0,0,0.1,0.003,0.009,0.01,0.05,0.05,0.08,0.1, 0.3],200)
 ).play
)
b.stop;


(
 f = Pbind(
  \instrument, \insect1,
  \freq,  Pwhite(20,300),
  \pink , Pwhite(6,20),
  \dur, Pwhite(0.8,4),
  \pan, Pwhite(0.5,1), 
  \amp, Prand([0,0,0.1,0.003,0.009,0.01,0.05,0.05,0.08,0.1, 0.3],200)
 ).play
)
f.stop;


(
e = Pbind(
   \instrument, \SinInsect,
   \freq, Prand([1/2,1/3,1/4,1/5,1/6,1/7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]*220,800) ,
   \mod , Pwhite(50,220),
   \dur, Pwhite(0.7,2),
   \harm1, Pwhite(120,880),
   \harm2, Pwhite(50,200),
  \amp, Pwhite(0.8,0.9)
).play
)
e.stop;

