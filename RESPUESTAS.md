<h3 class="p1"><span style="color: #ff6600;"><strong>Probando controllers:</strong></span></h3>
<p class="p1">&nbsp;</p>
<ul>
<li>Para listar todas las cuentas corrientes:</li>
</ul>
<blockquote>
<p class="p1">&nbsp; &nbsp; &nbsp; &nbsp; <span style="color: #000000;">curl -X GET "http://localhost:8080/api/account/findAll"</span></p>
<p class="p2">&nbsp;</p>
</blockquote>
<ul>
<li class="p1">Para agregar una nueva cuenta corriente:</li>
</ul>
<blockquote>
<p class="p1">&nbsp; &nbsp; &nbsp; &nbsp;<span style="color: #000000;">curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"id":1,"accountTypeCurrency":"USD", "accountTypeDescription":"Dollars"} 'http://localhost:8080/api/account/save</span></p>
</blockquote>
<p class="p2">&nbsp;</p>
<ul>
<li class="p1">Para eliminar una cuenta corriente:</li>
</ul>
<blockquote>
<p>&nbsp; &nbsp;<span style="color: #000000;"> &nbsp;<strong>Con movimientos</strong>: curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"id":1,"accountType":{"id":1,"accountTypeCurrency":"USD","accountTypeDescription":"Dollars"},"accountNumber":130444,"accountBalance":"100,00"}' http://localhost:8080/api/account/delete</span></p>
<p class="p1">&nbsp; &nbsp; &nbsp;<span style="color: #000000;"><strong>Sin movimientos</strong>: curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"id":2,"accountType":{"id":2,"accountTypeCurrency":"&euro;","accountTypeDescription":"Euros"},"accountNumber":240159,"accountBalance":"250,00"}}' http://localhost:8080/api/account/delete</span></p>
</blockquote>
<p class="p2">&nbsp;</p>
<ul>
<li class="p1">Para listar los movimientos de una cuenta corriente:</li>
</ul>
<blockquote>
<p class="p1">&nbsp; &nbsp; &nbsp;<span style="color: #000000;">curl -X GET 'http://localhost:8080/api/movement/findAllByAccount/1'</span></p>
</blockquote>
<p class="p2">&nbsp;</p>
<ul>
<li class="p1">Para agregar un nuevo movimiento:</li>
</ul>
<blockquote>
<p class="p1">&nbsp; &nbsp;<span style="color: #000000;"><strong>Con monto permitido</strong>: curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; </span>"account": {</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"id": 1,</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"accountType": {</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"id": 1,</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"accountTypeCurrency": "USD",</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"accountTypeDescription": "Dollars"</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>},</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"accountNumber": 130444,</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"accountBalance": "100.0"</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; </span>},</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; </span>"movementType": "Credit",</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; </span>"movementDescription": "Varios",</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; </span>"movementAmount": 100.0</span></p>
<p class="p1"><span style="color: #000000;">}' http://localhost:8080/api/movement/save</span></p>
<p class="p1"><span style="color: #000000;"><strong>&nbsp; &nbsp;Con monto excedido</strong>: curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; </span>"account": {</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"id": 1,</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"accountType": {</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"id": 1,</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"accountTypeCurrency": "USD",</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"accountTypeDescription": "Dollars"</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>},</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"accountNumber": 130444,</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>"accountBalance": "100.0"</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; </span>},</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; </span>"movementType": "Credit",</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; </span>"movementDescription": "Varios",</span></p>
<p class="p1"><span style="color: #000000;"><span class="Apple-converted-space">&nbsp; &nbsp; &nbsp; &nbsp; </span>"movementAmount": 1200.0</span></p>
<p class="p1"><span style="color: #000000;">}' http://localhost:8080/api/movement/save</span></p>
</blockquote>
<p class="p2"><span style="color: #000000;">&nbsp;</span></p>