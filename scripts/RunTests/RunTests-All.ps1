param ($suite)

if (!$suite) {
    $suite = Read-Host "What suite would you like to test for?"
}

Start-Process powershell -ArgumentList "-File RunTests-PaymentService-Integration.ps1 $suite"
Start-Process powershell -ArgumentList "-File RunTests-WebApplication-Integration.ps1 $suite"