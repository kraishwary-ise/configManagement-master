import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import {AuthGuard} from './auth/auth.guard';
import { ViewusecaseComponent } from './viewusecase/viewusecase.component';
import { AddusecaseComponent } from './addusecase/addusecase.component';
import { ErrorComponent } from './error/error.component';
import { LogOutComponent } from './log-out/log-out.component';
import { RouteGuardService } from './service/route-guard.service';
import { TriggerComponent } from './trigger/trigger.component';
import {OffersComponent} from './offers/offers.component';
import { SelectionComponent } from './selection/selection.component';



const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'usecase',component:ViewusecaseComponent,canActivate:[RouteGuardService]},
  {path:'addUseCase',component:AddusecaseComponent,canActivate:[RouteGuardService]},
  { path:'trigger/:useCaseId',component:TriggerComponent,canActivate:[RouteGuardService]},
  { path:'offers/:useCaseId',component:OffersComponent,canActivate:[RouteGuardService]},
  { path:'selection/:useCaseId',component:SelectionComponent,canActivate:[RouteGuardService]},


  {path:'logout',component:LogOutComponent},
  { path:'**',component:ErrorComponent}
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
