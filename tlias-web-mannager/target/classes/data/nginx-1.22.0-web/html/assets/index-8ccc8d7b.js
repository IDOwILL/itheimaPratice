import{e as V}from"./emp-34ba5cee.js";import{u as x}from"./loginEmp-cb0c9dd4.js";import{d as y,u as h,r as k,a as p,o as C,c as S,e as r,b as s,w as l,k as t,F as E,f as _,p as I,h as B,g as c,_ as F}from"./index-de6d9716.js";import"./request-24d06a0f.js";const N=n=>(I("data-v-03f0eb76"),n=n(),B(),n),P=N(()=>r("div",null,[r("div",{id:"title"},"修改密码"),r("br"),r("br")],-1)),U={class:"center"},L=y({__name:"index",setup(n){const w=x(),f=h();let e=k({password:"",repassword:"",newpassword:""});const v=async()=>{if(e.value.password!=e.value.repassword){c.error("两次输入密码不一致");return}let u=await V(e.value);u.code?(w.clearLoginEmp(),f.push("/login")):c.error(u.msg)},b=()=>{e.value={password:"",repassword:"",newpassword:""}};return(u,o)=>{const m=p("el-input"),d=p("el-form-item"),i=p("el-button"),g=p("el-form");return C(),S(E,null,[P,r("div",U,[s(g,{model:t(e),class:"demo-form-inline","label-width":"120px",width:"30%"},{default:l(()=>[s(d,{label:"原始密码"},{default:l(()=>[s(m,{type:"password",modelValue:t(e).password,"onUpdate:modelValue":o[0]||(o[0]=a=>t(e).password=a),placeholder:"请输入原始密码"},null,8,["modelValue"])]),_:1}),s(d,{label:"确认原始密码"},{default:l(()=>[s(m,{type:"password",modelValue:t(e).repassword,"onUpdate:modelValue":o[1]||(o[1]=a=>t(e).repassword=a),placeholder:"请再次输入原始密码"},null,8,["modelValue"])]),_:1}),s(d,{label:"新密码"},{default:l(()=>[s(m,{type:"password",modelValue:t(e).newpassword,"onUpdate:modelValue":o[2]||(o[2]=a=>t(e).newpassword=a),placeholder:"请输入新密码"},null,8,["modelValue"])]),_:1}),s(d,null,{default:l(()=>[s(i,{type:"primary",onClick:o[3]||(o[3]=a=>v())},{default:l(()=>[_("确定")]),_:1}),s(i,{type:"info",onClick:o[4]||(o[4]=a=>b())},{default:l(()=>[_("取消")]),_:1})]),_:1})]),_:1},8,["model"])])],64)}}});const T=F(L,[["__scopeId","data-v-03f0eb76"]]);export{T as default};
