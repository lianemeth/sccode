s.boot;

(
 SynthDef(\bell1, {|out = 0, freq, amp, dur, pan = 0, mod = 50, pink=100|

  var pm, modulator, env, panner;
  
  modulator = PMOsc.ar(mod,freq, 1, 0, 1);
  pm = SinOsc.ar(freq, modulator);
  
  env = EnvGen.kr(Env.perc(0.01,dur,amp), doneAction:2);
  panner = Pan2.ar(modulator, pan, env);
  
  Out.ar(out, panner);
 }).store
)

(
 SynthDef(\bell2, {|out = 0, freq, amp, dur, pan = 0, mod = 50, pink=100|

  var pm, modulator, env, panner;
  
  modulator = Saw.ar(mod, 0.5, 0);
  pm = SinOsc.ar(freq, modulator*2.81);
  
  env = EnvGen.kr(Env.triangle(dur,1), doneAction:2);
  panner = Pan2.ar(modulator, pan, env);
  
  Out.ar(out, panner);
 }).store
)

(
a = Pbind(
\instrument , \bell1,
\freq, Pwhite(40,440),
\dur, Pwhite(0.5, 4),
\amp , Pwhite(0.05, 0.5),
\mod, Pwhite(110,1100),
\pink, Pwhite(110,220)
).play
)
a.stop;
(
b = Pbind(
\instrument , \bell2,
\freq, Pwhite(11000,16000),
\dur, Pwhite(0.01, 0.09),
\amp , Pwhite(0.02, 0.05),
\mod, Pwhite(880,1400),
\pink, Pwhite(80,220)
).play
)
b.stop;
