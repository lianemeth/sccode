s.boot;
s.quit;
//default values for synthdef
(
 SynthDef(\example9, {|out = 0, freq, amp, dur, pan = 0, mod = 50|
  
  //variables
  var pm, modulator, env, panner;
  
  //modulator
  modulator = SinOsc.ar(mod, 0, 0.2);

  pm = SinOsc.ar(freq, modulator);
  
  //envelope
  env = EnvGen.kr(Env.perc(0.01, dur, amp), doneAction:2);
  //pan
  panner = Pan2.ar(pm, pan, env);
  
  Out.ar(out, panner);
 }).store
)


//Same sequence, new random fixed duration each evaluation
(
 a= Pbind(
  \instrument, \example9,
  \freq,  Pseq([ 1/1, 3/2, 4/3, 9/8, 16/9, 5/4, 8/5 ] * 440, inf),
  \dur, 0.2 + 0.3.rand
 ).play
)
a.stop;

